package com.github.olegagrus.plot_accounting.plot.controller;

import com.github.olegagrus.plot_accounting.plot.model.ConfiguredResponse;
import com.github.olegagrus.plot_accounting.plot.model.Plot;
import com.github.olegagrus.plot_accounting.plot.service.PlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plot")
public class PlotController {

    private final PlotService plotService;

    @Autowired
    public PlotController(PlotService plotService) {
        this.plotService = plotService;
    }

    @GetMapping("/all")
    public ResponseEntity<ConfiguredResponse> getAllPlots() {
        return ResponseEntity
                .ok()
                .body(plotService.getAllPlots());
    }

    @PutMapping("/sell/{plotId}")
    public ResponseEntity<ConfiguredResponse> sellPlot(@PathVariable long plotId) {
        return ResponseEntity
                .ok()
                .body(plotService.sellPlot(plotId));
    }

    @PostMapping("/add")
    public ResponseEntity<ConfiguredResponse> addPlot(@RequestBody Plot plot) {
        return ResponseEntity
                .ok()
                .body(plotService.addPlot(plot));
    }

}
