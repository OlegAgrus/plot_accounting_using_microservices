import * as React from "react";
import './PlotItem.css';
import {Link} from "react-router-dom";

export class PlotItem extends React.Component{

    constructor(props) {
        super(props);

        this.state = {
            id: props.id,
            adr: props.adr,
            pricePerHectare: props.pricePerHectare,
            hectares: props.hectares,
            sold: props.sold,
        };
    }

    getSold = () => {
        return this.state.sold === true ? "sold" : "available";
    };

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
                    {`${this.state.id} | ${this.state.adr} | hectare cost: ${this.state.pricePerHectare} | hectares: ${this.state.hectares}`}
                    <span className="badge badge-primary badge-pill">{this.getSold()}</span>
                </li>
            </Link>

        );
    }

}