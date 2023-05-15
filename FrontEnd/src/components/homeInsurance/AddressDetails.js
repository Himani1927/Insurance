import { Button, Checkbox, FormControlLabel, Grid, Radio, RadioGroup, TextField, Typography } from '@mui/material'
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
      <Typography variant='h5' gutterBottom>Address Details</Typography>
      <form onSubmit={handleNext}>
        <Grid container spacing={1.5} style={{ padding: '5px' }} >
          <Grid item xs={12}>
            <Typography gutterBottom>Property Address</Typography>
          </Grid>
          <Grid item xs={6} >
            <TextField label="Address" color='secondary' fullWidth
              value={insuranceData.propertyAddress} name='propertyAddress'
              variant='outlined' onChange={handleChange} required />
          </Grid>
          <Grid item xs={6} >
            <TextField label="City" color='secondary' fullWidth
              value={insuranceData.propertyCity} name='propertyCity'
              variant='outlined' onChange={handleChange} required />
          </Grid>
          <Grid item xs={6} >
            <TextField label="State" color='secondary' fullWidth
              value={insuranceData.propertyState} name='propertyState'
              variant='outlined' onChange={handleChange} required />
          </Grid>
          <Grid item xs={6} >
            <TextField label="Pincode" type='number' color='secondary' fullWidth
              value={insuranceData.propertyPincode} name='propertyPincode'
              variant='outlined' onChange={handleChange} required />
          </Grid>

          <Grid item xs={12} marginTop={'2px'}>
            <Typography marginTop={'2px'}>Communication Address</Typography>
          </Grid>
          <Grid item xs={12}>
            <Typography sx={{ display: 'inline' }} variant='subtitle2'>Is Same as Property Address?</Typography>
            <Checkbox sx={{ display: 'inline' }} color='success' size='large' checked={insuranceData.isPresentAddress}
              name='isPresentAddress' onChange={handleCheckbox}
            ></Checkbox>
          </Grid>
          <Grid item xs={6} >
            <TextField label="Address" color='secondary' fullWidth
              value={insuranceData.communicationAddress} name='communicationAddress'
              variant='outlined' required disabled={insuranceData.isPresentAddress}
              onChange={handleChange}  />
          </Grid>
          <Grid item xs={6} >
            <TextField label="City" color='secondary' fullWidth
              value={insuranceData.communicationCity} name='communicationCity'
              variant='outlined' required disabled={insuranceData.isPresentAddress} 
              onChange={handleChange}/>
          </Grid>
          <Grid item xs={6} >
            <TextField label="State" color='secondary' fullWidth
              value={insuranceData.communicationState} name='communicationState'
              variant='outlined' required disabled={insuranceData.isPresentAddress} 
              onChange={handleChange}/>
          </Grid>
          <Grid item xs={6} >
            <TextField label="Pincode" type='number' color='secondary' fullWidth
              value={insuranceData.communicationPincode} name='communicationPincode'
              variant='outlined' required disabled={insuranceData.isPresentAddress} 
              onChange={handleChange}/>
          </Grid>
          <Grid item xs={12} sm={6}>
            <Button variant='contained' color='secondary' fullWidth onClick={handleBack}>Back</Button>
          </Grid>
          <Grid item xs={12} sm={6}>
            <Button variant='contained' type='submit' color='secondary' fullWidth  >Next</Button>
          </Grid>
        </Grid>
      </form>
    </div>
  )
}
