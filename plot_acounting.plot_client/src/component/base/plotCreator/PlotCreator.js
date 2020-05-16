import React from 'react';
import './PlotCreator.css';
import axios from "axios";

export class PlotCreator extends React.Component{

    constructor(props) {
        super(props);

        this.url = 'http://localhost:8762';

        this.state = {

        }
    }

    componentDidMount() {
    }

    onCreate = (event) => {
        let createUrl = `${this.url}/plot-accounter-plot/plot/add`;
        let creationForm = event.target.parentElement;
        let createData = {
            adr: creationForm.address.value,
            pricePerHectare: +creationForm.price.value,
            hectares: +creationForm.hectares.value,
            sold: creationForm.sold.checked,
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
                            <label htmlFor="newPlotAdr">Address:</label>
                            <input name="address" type="text" className="form-control" id="newPlotAdr"
                                   placeholder=""/>
                        </div>
                        <div className="form-group">
                            <label htmlFor="newPlotPrice">Price:</label>
                            <input name="price" type="text" className="form-control" id="newPlotPrice"
                                   placeholder=""/>
                        </div>
                        <div className="form-group">
                            <label htmlFor="newPlotHectares">Hectares:</label>
                            <input name="hectares" type="text" className="form-control" id="newPlotHectares"
                                   placeholder=""/>
                        </div>
                        <div className="custom-control custom-switch">
                            <input name="sold" type="checkbox" className="custom-control-input" id="newPlotSold" value="true"/>
                            <label className="custom-control-label" htmlFor="newPlotSold">Is plot already sold?</label>
                        </div>
                        <br/>
                        <button onClick={this.onCreate} type="button" className="btn btn-primary">Create</button>
                    </form>
                </div>
            </div>
        );
    }

}