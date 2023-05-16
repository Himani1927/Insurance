import { Button, Checkbox, Grid, TextField, Typography } from '@mui/material'
import React from 'react'

export default function AddressDetails({
    insuranceData, setInsuranceData, handleNext, handleBack
}) {
    const handleChange = (e) => {
        setInsuranceData({ ...insuranceData, [e.target.name]: e.target.value })
        console.log(insuranceData)
      }
    
      const handleCheckbox = (e) => {
        setInsuranceData({ ...insuranceData, [e.target.name]: e.target.checked })
      }
    
    
      return (
        <div style={{ maxWidth: '750px', margin: '10px auto' }}>
          <Typography variant='h5' gutterBottom margin={'auto'}>Address Details</Typography>
          <form onSubmit={handleNext}>
            <Grid container spacing={1.5} style={{ padding: '5px' }} >
              <Grid item xs={12}>
                <Typography gutterBottom>Permanent Address</Typography>
              </Grid>
              <Grid item xs={6} >
                <TextField label="Address" color='secondary' fullWidth
                  value={insuranceData.address} name='address'
                  variant='outlined' onChange={handleChange} required />
              </Grid>
              <Grid item xs={6} >
                <TextField label="City" color='secondary' fullWidth
                  value={insuranceData.city} name='city'
                  variant='outlined' onChange={handleChange} required />
              </Grid>
              <Grid item xs={6} >
                <TextField label="State" color='secondary' fullWidth
                  value={insuranceData.state} name='state'
                  variant='outlined' onChange={handleChange} required />
              </Grid>
              <Grid item xs={6} >
                <TextField label="Pincode" type='number' color='secondary' fullWidth
                  value={insuranceData.pincode} name='pincode'
                  variant='outlined' onChange={handleChange} required />
              </Grid>
              <Grid marginTop={'15px'} item xs={12} sm={6}>
                <Button variant='contained' color='secondary' fullWidth onClick={handleBack}>Back</Button>
              </Grid>
              <Grid marginTop={'15px'} item xs={12} sm={6}>
                <Button variant='contained' type='submit' color='secondary' fullWidth  >Next</Button>
              </Grid>
            </Grid>
          </form>
        </div>
      )
    }
