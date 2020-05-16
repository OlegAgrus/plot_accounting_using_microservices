package com.github.olegagrus.plot_accounting.plot_selling.service;

import com.github.olegagrus.plot_accounting.plot_selling.model.ConfiguredResponse;
import com.github.olegagrus.plot_accounting.plot_selling.model.PlotSelling;

public interface PlotSellingService {
    ConfiguredResponse getAllSellings();

    ConfiguredResponse sellItem(PlotSelling plotSelling);
}
