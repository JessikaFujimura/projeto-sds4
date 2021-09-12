import axios from 'axios';
import { useEffect, useState } from 'react';
import Chart from 'react-apexcharts';
import { SaleSuccess } from 'types/sale';
import { round } from 'utils/Format';
import { BASE_URL } from 'utils/requests';

type SeriesData = {
    name: string,
    data: number[]
}

type ChartData = {
    labels: { categories: string[]},
    series: SeriesData[]
}


function BarChart(params:any) {

    const [chartData, setChartData] = useState<ChartData>({
        labels: {
            categories: []
        },
        series: [
            {
                name: "",
                data: []                   
            }
        ]
    })

    const options = {
        plotOptions: {
            bar: {
                horizontal: true,
            }
        },
    };

    useEffect(() => {
        axios.get(`${BASE_URL}/sales/success-by-seller`).then(response => {
            const data = response.data as SaleSuccess[];
            const myLabels = data.map(i => i.sellerName);
            const mySeries = data.map(i => round( 100 * i.deals/i.visited, 1))

            setChartData({
                labels: {
                    categories: myLabels
                },
                series: [
                    {
                        name: "% Success",
                        data: mySeries                   
                    }
                ]
            })
        })
    }, [])
    
    
    return (
        <Chart 
        options={{ ...options, xaxis:chartData.labels}} 
        series={chartData.series} 
        type="bar"
        height="240"
        />
    )
}

export default BarChart;