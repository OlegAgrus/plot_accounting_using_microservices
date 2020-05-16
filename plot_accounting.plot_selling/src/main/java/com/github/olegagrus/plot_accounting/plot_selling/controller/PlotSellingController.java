package com.github.olegagrus.plot_accounting.plot_selling.controller;

import com.github.olegagrus.plot_accounting.plot_selling.model.ConfiguredResponse;
import com.github.olegagrus.plot_accounting.plot_selling.model.PlotSelling;
import com.github.olegagrus.plot_accounting.plot_selling.service.PlotSellingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/plot-selling")
public class PlotSellingController {

    private PlotSellingService plotSellingService;

    @Autowired
    public PlotSellingController(PlotSellingService plotSellingService) {
        this.plotSellingService = plotSellingService;
    }

    @GetMapping("/all")
    public ResponseEntity<ConfiguredResponse> getAllSellings() {
        return ResponseEntity
                .ok()
                .body(plotSellingService.getAllSellings());
    }

    @PostMapping("/sell")
    public ResponseEntity<ConfiguredResponse> sellPlot(@RequestBody PlotSelling plotSelling) {
        return ResponseEntity
                .ok()
                .body(plotSellingService.sellItem(plotSelling));
    }

}
