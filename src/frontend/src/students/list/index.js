import React from 'react';
import { DataGrid } from '@material-ui/data-grid';
import { useHistory } from 'react-router-dom';

const columns = [
  { field: 'id', headerName: 'ID', width: 70 },
  { field: 'name', headerName: 'Name', flex: 1 },
  { field: 'surname', headerName: 'Surname', flex: 1 },
  {
    field: 'accountName',
    headerName: 'Account name',
    flex: 1,
  },
  {
    field: 'email',
    headerName: 'Email',
    width: 200,
  },
];

export default function StudentList({ epoch }) {
  const history = useHistory();

  const [fetching, setFetching] = React.useState(false);
  const [students, setStudents] = React.useState([]);

  React.useEffect(() => {
    fetch(`${process.env.REACT_APP_API}/student/getAll`, {
      method: 'GET',
      mode: 'cors',
      headers: {
        'Content-Type': 'application/json',
        Accept: 'application/json',
      },
    })
      .then((result) => result.json())
      .then((result) => {
        setStudents(result);
        setFetching(false);
      });
    setFetching(true);
  }, [epoch]);

  return (
    <div style={{ display: 'flex', height: '100%' }}>
      <div style={{ flexGrow: 1 }}>
        <DataGrid
          columns={columns}
          rows={students}
          pageSize={10}
          rowHeight={36}
          hideFooterSelectedRowCount={true}
          disableSelectionOnClick={true}
          loading={fetching}
          onRowClick={(params) => {
            history.push('/student/' + params.row.id);
          }}
        ></DataGrid>
      </div>
    </div>
  );
}
