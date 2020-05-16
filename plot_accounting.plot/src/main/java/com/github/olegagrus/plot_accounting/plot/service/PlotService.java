package com.github.olegagrus.plot_accounting.plot.service;

import com.github.olegagrus.plot_accounting.plot.model.ConfiguredResponse;
import com.github.olegagrus.plot_accounting.plot.model.Plot;

import java.util.List;

public interface PlotService {
    ConfiguredResponse getAllPlots();

    ConfiguredResponse sellPlot(long plotId);

    ConfiguredResponse addPlot(Plot plot);
}
