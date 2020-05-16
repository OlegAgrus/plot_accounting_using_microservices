package com.github.olegagrus.plot_accounting.plot_selling.proxy;

import com.github.olegagrus.plot_accounting.plot_selling.model.ConfiguredResponse;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "zuul-server")
@RibbonClient(name = "zuul-server")
@RequestMapping("/plot-accounter-plot/plot")
public interface PlotServiceProxy {

    @PutMapping("/sell/{plotId}")
    public ResponseEntity<ConfiguredResponse> sellPlot(@PathVariable long plotId);

}
