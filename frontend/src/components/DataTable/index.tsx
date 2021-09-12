import axios from "axios";
import { useEffect, useState } from "react";
import { SalePage } from "types/sale";
import { formatLocalDate } from "utils/Format";
import { BASE_URL } from "utils/requests";

function DataTable(params: any) {

    const [page, setPage] = useState<SalePage>({
        last: true,
        totalElements: 0,
        totalPages: 0,
        first: true,
        number: 0,
    })


    useEffect(() => {
        axios.get(`${BASE_URL}/sales?size=20&page=0&sort=date,asc`)
        .then(response => {
            setPage(response.data)
        })
    }, [])

    return (
        <div className="table-responsive">
            <table className="table table-striped table-sm">
                <thead>
                    <tr>
                        <th>Data</th>
                        <th>Vendedor</th>
                        <th>Clientes visitados</th>
                        <th>Negócios fechados</th>
                        <th>Valor</th>
                    </tr>
                </thead>
                <tbody>
                    {page.content?.map(i => 
                    <tr key={i.id}>
                        <td>{formatLocalDate(i.date, "dd/MM/yyyy")}</td>
                        <td>{i.seller.name}</td>
                        <td>{i.visited}</td>
                        <td>{i.deals}</td>
                        <td>{i.amount.toFixed(2)}</td>
                    </tr>
                    )}
                </tbody>
            </table>
        </div>
    )
}

export default DataTable;