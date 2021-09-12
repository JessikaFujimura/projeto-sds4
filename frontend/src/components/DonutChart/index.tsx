import axios from 'axios';
import { useEffect } from 'react';
import Chart from 'react-apexcharts';
import { SaleSum } from 'types/sale';
import { BASE_URL } from 'utils/requests';

type ChartData = {
    series: number[],
    labels: string[]
}

function DonutChart(params:any) {

    let chartData : ChartData = {
        series: [],
        labels: []
    }

    useEffect(() => {

    }, [])

    axios.get(`${BASE_URL}/sales/amount-by-seller`).then(
        response => {
            const data = response.data as SaleSum[];
            const myLabels = data.map( i => i.sellerName);
            const mySeries = data.map( i => i.sum);
            chartData = { series: mySeries, labels: myLabels}
        }
    )

    // const mockData= {
    //     series: [477138, 499928, 444867, 220426, 473088],
    //     labels: ['Anakin', 'Barry Allen', 'Kal-El', 'Logan', 'Padmé']
    // }
    
    const options = {
        legend: {
            show: true
        }
    }

    return (
        <Chart 
        options={{ ...options, labels:chartData.labels}} 
        series={chartData.series} 
        type="donut"
        height="240"/>
    )
}

export default DonutChart;