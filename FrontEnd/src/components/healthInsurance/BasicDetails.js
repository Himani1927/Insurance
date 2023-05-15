import { Button, Grid, TextField, Typography } from '@mui/material'
import React from 'react'

export default function BasicDetails({
    insuranceData, setInsuranceData, handleNext
}) {

    const handleChange = (e) => {
        setInsuranceData({ ...insuranceData, [e.target.name]: e.target.value })
    }

    return (
        <div style={{ maxWidth: '750px', margin: '10px auto' }}>
            <Typography variant='h5' gutterBottom>Basic Info</Typography>
            <form onSubmit={handleNext}>
                <Grid container spacing={1.5} style={{ padding: '5px' }} >
                    <Grid item xs={12} sm={6}>
                        <TextField label="First Name" color='secondary' fullWidth
                            value={insuranceData.firstName} name='firstName'
                            onChange={handleChange}
                            variant='outlined' placeholder='Enter First Name' required />
                    </Grid>
                    <Grid item xs={12} sm={6}>
                        <TextField label="Last Name" color='secondary' fullWidth
                            value={insuranceData.lastName} name='lastName'
                            onChange={handleChange}
                            variant='outlined' placeholder='Enter Last Name' required />
                    </Grid>
                    <Grid item xs={12}>
                        <TextField label="Email" color='secondary' type='email' fullWidth
                            value={insuranceData.email} name='email'
                            onChange={handleChange}
                            variant='outlined' placeholder='Enter e-Mail address' required />
                    </Grid>
                    <Grid item xs={12} >
                        <TextField label="Contact no." color='secondary' type='number' fullWidth
                            value={insuranceData.contactNo} name='contactNo'
                            onChange={handleChange}
                            variant='outlined' placeholder='Enter Contact Number' required />
                    </Grid>
                    <Grid item xs={12}>
                        <Button variant='contained' type='submit' color='secondary' fullWidth >Next</Button>
                    </Grid>
                </Grid>
            </form>

        </div>
    )
}
