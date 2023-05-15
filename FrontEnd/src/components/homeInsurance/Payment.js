import { Grid, Typography } from '@mui/material'
import React from 'react'

export default function Payment({
    insuranceData, setInsuranceData
}) {
  return (
    <div style={{ maxWidth: '750px', margin: '10px auto' }}>
        <Typography variant='h5' gutterBottom>Payment Process</Typography>
        <form>
        <Grid container spacing={1.5} style={{ padding: '5px' }} >

        </Grid>
        </form>
    </div>
  )
}
