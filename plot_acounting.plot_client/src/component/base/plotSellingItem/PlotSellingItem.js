import * as React from "react";
import './PlotSellingItem.css';
import {Link} from "react-router-dom";

export class PlotSellingItem extends React.Component{

    constructor(props) {
        super(props);

        this.state = {
            id: props.id,
            customerName: props.customerName,
            customerSurname: props.customerSurname,
            plotId: props.plotId,
            transactionTime: props.transactionTime,
        };
    }

    render() {
        return(
            /*<a className="conference-list-item-link" href={'conference/' + this.state.id}>
                <li className="conference-list-item list-group-item d-flex justify-content-between align-items-center">
                    {this.state.name}
                    <span className="badge badge-primary badge-pill">{this.state.participants.length}/{this.state.maxSeats}</span>
                </li>
            </a>*/
            <Link to={'/#'}>
                <li className="conference-list-item list-group-item d-flex justify-content-between align-items-center">
                    {`${this.state.id} | ${this.state.customerName} | ${this.state.customerSurname} | plot id: ${this.state.plotId}`}
                    <span className="badge badge-primary badge-pill">{this.state.transactionTime}</span>
                </li>
            </Link>

        );
    }

}