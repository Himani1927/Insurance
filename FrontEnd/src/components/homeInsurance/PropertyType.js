import React from 'react'
import {
    TextField, Button, CardContent, Card, Grid,
    Typography, Radio, RadioGroup, FormControlLabel, Checkbox
} from '@mui/material'

import '../../App.css'

export default function PropertyType({
    insuranceData, setInsuranceData,handleNext, handleBack
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
            <Typography variant='h5' gutterBottom>Property Info</Typography>
            <form onSubmit={handleNext}>
                <Grid container spacing={1.5} style={{ padding: '5px' }} >
                    <Grid item xs={3}>
                        <Typography>Property Type</Typography>
                    </Grid>
                    <Grid item xs={9}>
                        <RadioGroup value={insuranceData.propertyType} onChange={handleChange}>
                            <FormControlLabel value="Apartment" name='propertyType' control={<Radio color="primary" />} label="Apartment" />
                            <FormControlLabel value="House" name='propertyType' control={<Radio color="primary" />} label="House" />
                        </RadioGroup>
                    </Grid>
                    <Grid item xs={3}>
                        <Typography>Resident Type</Typography>
                    </Grid>
                    <Grid item xs={9}>
                        <RadioGroup value={insuranceData.residentType} onChange={handleChange}>
                            <FormControlLabel value="Owner" name='residentType' control={<Radio color="primary" />} label="Owner" />
                            <FormControlLabel value="Tenant" name='residentType' control={<Radio color="primary" />} label="Tenant" />
                        </RadioGroup>
                    </Grid>
                    <Grid item xs={4}>
                        <Typography>What you want to Insure</Typography>
                    </Grid>
                    <Grid item xs={8}>
                        <Typography sx={{ display: 'inline' }}>Building</Typography>
                        <Checkbox sx={{ display: 'inline' }} color='success' size='large' checked={insuranceData.insureBuilding}
                            name='insureBuilding' onChange={handleCheckbox} disabled={insuranceData.residentType === 'Tenant'}
                        ></Checkbox>
                        <Typography sx={{ display: 'inline' }}>Household Items</Typography>
                        <Checkbox sx={{ display: 'inline' }} color='success' size='large' checked={insuranceData.insureHouseholdItems}
                            name='insureHouseholdItems' onChange={handleCheckbox}
                        ></Checkbox>
                    </Grid>
                    <Grid item xs={12} >
                        <TextField label="Building Value" color='secondary' type='number' fullWidth
                            value={insuranceData.buildingValue} name='buildingValue'
                            onChange={handleChange} disabled={!insuranceData.insureBuilding}
                            variant='outlined' placeholder='Enter the Value of Building' required />
                    </Grid>
                    <Grid item xs={12} >
                        <TextField label="Items Value" color='secondary' type='number' fullWidth
                            value={insuranceData.itemsValue} name='itemsValue'
                            onChange={handleChange} disabled={!insuranceData.insureHouseholdItems}
                            variant='outlined' placeholder='Enter the Value of HouseHold Items' required />
                    </Grid>
                    <Grid item xs={12} sm={6}>
                        <Button variant='contained' color='secondary' fullWidth onClick={handleBack}>Back</Button>
                    </Grid>
                    <Grid item xs={12} sm={6}>
                        <Button variant='contained' type='submit' color='secondary' fullWidth >Next</Button>
                    </Grid>
                </Grid>
            </form>
        </div>
    )
}
