package com.github.olegagrus.plot_accounting.plot_selling.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ConfiguredResponse {

    private Object responseObject;

    private int port;

}
