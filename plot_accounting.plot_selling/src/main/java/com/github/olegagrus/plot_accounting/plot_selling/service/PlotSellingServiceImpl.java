package com.github.olegagrus.plot_accounting.plot_selling.service;

import com.github.olegagrus.plot_accounting.plot_selling.model.ConfiguredResponse;
import com.github.olegagrus.plot_accounting.plot_selling.model.PlotSelling;
import com.github.olegagrus.plot_accounting.plot_selling.proxy.PlotServiceProxy;
import com.github.olegagrus.plot_accounting.plot_selling.repository.PlotSellingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PlotSellingServiceImpl implements PlotSellingService {

    private PlotSellingRepository plotSellingRepository;
    private Environment environment;
    private PlotServiceProxy plotServiceProxy;

    @Autowired
    public PlotSellingServiceImpl(PlotSellingRepository plotSellingRepository, Environment environment, PlotServiceProxy plotServiceProxy) {
        this.plotSellingRepository = plotSellingRepository;
        this.environment = environment;
        this.plotServiceProxy = plotServiceProxy;
    }

    @Override
    public ConfiguredResponse getAllSellings() {
        List<PlotSelling> plotList = plotSellingRepository.findAll();

        return ConfiguredResponse.builder()
                .responseObject(plotList)
                .port(Integer.parseInt(environment.getProperty("local.server.port")))
                .build();
    }

    @Override
    public ConfiguredResponse sellItem(PlotSelling plotSelling) {
        long plotId = plotSelling.getPlotId();

        ResponseEntity<ConfiguredResponse> plotResponse = plotServiceProxy.sellPlot(plotId);
        System.out.println(plotResponse.getStatusCode());
        System.out.println(plotResponse.getBody().getPort());

        if (plotResponse.getStatusCode() != HttpStatus.OK) {
            throw new RuntimeException("Plot doesn't exist by id: " + plotId);
        }

        PlotSelling newSelling = PlotSelling.builder()
                .customerName(plotSelling.getCustomerName())
                .customerSurname(plotSelling.getCustomerSurname())
                .transactionTime(new Date())
                .plotId(plotId)
                .build();

        return ConfiguredResponse.builder()
                .responseObject(plotSellingRepository.save(newSelling))
                .port(Integer.parseInt(environment.getProperty("local.server.port")))
                .build();
    }

}
