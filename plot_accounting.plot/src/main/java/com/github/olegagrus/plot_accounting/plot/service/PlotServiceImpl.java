package com.github.olegagrus.plot_accounting.plot.service;

import com.github.olegagrus.plot_accounting.plot.model.ConfiguredResponse;
import com.github.olegagrus.plot_accounting.plot.model.Plot;
import com.github.olegagrus.plot_accounting.plot.repository.PlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlotServiceImpl implements PlotService {

    private final PlotRepository plotRepository;
    private final Environment environment;

    @Autowired
    public PlotServiceImpl(PlotRepository plotRepository, Environment environment) {
        this.plotRepository = plotRepository;
        this.environment = environment;
    }

    @Override
    public ConfiguredResponse getAllPlots() {

        List<Plot> plotList = plotRepository.findAll();

        return ConfiguredResponse.builder()
                .responseObject(plotList)
                .port(Integer.parseInt(environment.getProperty("local.server.port")))
                .build();
    }

    @Override
    public ConfiguredResponse sellPlot(long plotId) {
        Plot plot = plotRepository.findById(plotId)
                .orElseThrow(() -> new RuntimeException("plot doesn't exist by id"));

        if (plot.isSold()) {
            throw new RuntimeException("plot is already sold");
        }
        plot.setSold(true);

        return ConfiguredResponse.builder()
                .responseObject(plotRepository.save(plot))
                .port(Integer.parseInt(environment.getProperty("local.server.port")))
                .build();
    }

    @Override
    public ConfiguredResponse addPlot(Plot plot) {
        return ConfiguredResponse.builder()
                .responseObject(plotRepository.save(plot))
                .port(Integer.parseInt(environment.getProperty("local.server.port")))
                .build();
    }

}
