import React from 'react';
import axios from 'axios';
import './base.css';
import {PlotItem} from "./plotItem/PlotItem";
import {PlotSellingItem} from "./plotSellingItem/PlotSellingItem";


export class Base extends React.Component{

    constructor(props) {
        super(props);

        this.url = 'http://localhost:8762';

        this.state = {
            plotList: [],
            plotSellingList: [],
        };

    }

    componentDidMount() {
        this.initPlotList()
            .finally(() => this.initPlotSellingList());
    }

    initPlotList = () => {
        return this.loadPlotList()
            .then((response) => this.setState({plotList: response.data.responseObject}));
    };

    loadPlotList = () => {
        let loadUrl = `${this.url}/plot-accounter-plot/plot/all`;
        return axios.get(loadUrl, {withCredentials: true});
    };

    initPlotSellingList = () => {
        return this.loadPlotSellingList()
            .then((response) => this.setState({plotSellingList: response.data.responseObject}));
    };

    loadPlotSellingList = () => {
        let loadUrl = `${this.url}/plot-accounter-sellings/plot-selling/all`;
        return axios.get(loadUrl, {withCredentials: true});
    };

    onNewPlotClick = () => {
        this.props.history.push("/new_plot");
    };

    onNewPlotSellingClick = () => {
        this.props.history.push("/new_plot_selling");
    };

    render() {
        return(
            <div>
                <div className="base-block">
                    <h2 className="conference-list-header">Plots</h2>
                    <div className="conference-list-button-container">
                        <button onClick={this.onNewPlotClick} type="button" className="btn btn-outline-primary">+</button>
                    </div>
                    <div className="conference-list-container">
                        <ul className="conference-list list-group">
                            {this.state.plotList.map((item) => {
                                return (
                                    <PlotItem
                                        id={item.id}
                                        key={item.id}
                                        adr={item.adr}
                                        pricePerHectare={item.pricePerHectare}
                                        hectares={item.hectares}
                                        sold={item.sold}
                                    />
                                );
                            })}
                        </ul>
                    </div>
                </div>
                <div className="base-block">
                    <h2 className="conference-list-header">Plot sellings</h2>
                    <div className="conference-list-button-container">
                        <button onClick={this.onNewPlotSellingClick} type="button" className="btn btn-outline-primary">+</button>
                    </div>
                    <div className="conference-list-container">
                        <ul className="conference-list list-group">
                            {this.state.plotSellingList.map((item) => {
                                return (
                                    <PlotSellingItem
                                        id={item.id}
                                        key={item.id}
                                        customerName={item.customerName}
                                        customerSurname={item.customerSurname}
                                        plotId={item.plotId}
                                        transactionTime={item.transactionTime}
                                    />
                                );
                            })}
                        </ul>
                    </div>
                </div>
            </div>
        );
    }
}
