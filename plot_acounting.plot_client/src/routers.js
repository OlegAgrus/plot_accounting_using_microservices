import React from 'react';
import {Route, Switch} from 'react-router';
import {BrowserRouter} from 'react-router-dom';
import {Base} from "./component/base/base";
import {PlotCreator} from "./component/base/plotCreator/PlotCreator";
import {PlotSellingCreator} from "./component/base/plotSellingCreator/PlotSellingCreator";

export class Routers extends React.Component{
    render() {
        return(
            <BrowserRouter>
                <Switch>
                    <Route exact path="/" component={Base}/>
                    <Route path="/new_plot" component={PlotCreator}/>
                    <Route path="/new_plot_selling" component={PlotSellingCreator}/>
                </Switch>
            </BrowserRouter>
        );
    }
}