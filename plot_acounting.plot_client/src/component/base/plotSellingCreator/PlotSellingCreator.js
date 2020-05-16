import React from 'react';
import './PlotSellingCreator.css';
import axios from "axios";

export class PlotSellingCreator extends React.Component{

    constructor(props) {
        super(props);

        this.url = 'http://localhost:8762';

        this.state = {

        }
    }

    componentDidMount() {
    }

    onCreate = (event) => {
        let createUrl = `${this.url}/plot-accounter-sellings/plot-selling/sell`;
        let creationForm = event.target.parentElement;
        let createData = {
            customerName: creationForm.customerName.value,
            customerSurname: creationForm.customerSurname.value,
            plotId: +creationForm.plotId.value,
        };
        console.log(createData);
        axios.post(createUrl, createData, {withCredentials: true}).then(() => this.props.history.push("/"));
    };

    render() {
        return(
            <div>
                <h2 className="conference-list-header">New Plot</h2>
                <div className="conference-creation-form-container">
                    <form>
                        <div className="form-group">
                            <label htmlFor="newCustomerName">Customer name:</label>
                            <input name="customerName" type="text" className="form-control" id="newCustomerName"
                                   placeholder=""/>
                        </div>
                        <div className="form-group">
                            <label htmlFor="newCustomerSurname">Customer Surname:</label>
                            <input name="customerSurname" type="text" className="form-control" id="newCustomerName"
                                   placeholder=""/>
                        </div>
                        <div className="form-group">
                            <label htmlFor="newPlotId">Plot id:</label>
                            <input name="plotId" type="text" className="form-control" id="newPlotId"
                                   placeholder=""/>
                        </div>
                        <br/>
                        <button onClick={this.onCreate} type="button" className="btn btn-primary">Create</button>
                    </form>
                </div>
            </div>
        );
    }

}