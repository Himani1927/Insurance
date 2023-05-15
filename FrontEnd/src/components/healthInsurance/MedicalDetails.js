import { Button, Checkbox, FormControlLabel, Grid, Radio, RadioGroup, TextField, Typography } from '@mui/material'
import React from 'react'

export default function MedicalDetails({
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
            <Typography variant='h5' gutterBottom>Medical Details</Typography>
            <form>
                <Grid container spacing={1.5} style={{ padding: '5px' }} >
                    <Grid item xs={6}>
                        <Typography sx={{ display: 'inline' }} marginRight={'25px'}>Gender</Typography>
                        <RadioGroup sx={{ display: 'inline' }} value={insuranceData.gender} onChange={handleChange}>
                            <FormControlLabel sx={{ display: 'inline' }} value="Male" name='gender' control={<Radio color="primary" />} label="Male" />
                            <FormControlLabel sx={{ display: 'inline' }} value="Female" name='gender' control={<Radio color="primary" />} label="Female" />
                        </RadioGroup>
                    </Grid>
                    <Grid item xs={6} >
                        <TextField label="Age" color='secondary' type='number' fullWidth
                            value={insuranceData.age} name='age' onChange={handleChange}
                            variant='outlined' placeholder='Enter Age in years' required />
                    </Grid>
                    <Grid item xs={6}>
                        <TextField label="Height" color='secondary' type='number' fullWidth
                            value={insuranceData.height} name='height' onChange={handleChange}
                            variant='outlined' placeholder='Enter Height in centimeters' required />
                    </Grid>
                    <Grid item xs={6}>
                        <TextField label="Weight" color='secondary' type='number' fullWidth
                            value={insuranceData.weight} name='weight' onChange={handleChange}
                            variant='outlined' placeholder='Enter Weight in Kgs' required />
                    </Grid>
                    <Grid item xs={6}>
                        <Typography sx={{ display: 'inline' }} variant='subtitle2'>Do you have any Prior Illness?</Typography>
                        <Checkbox sx={{ display: 'inline' }} color='success' size='large' checked={insuranceData.hasPriorIllness}
                            name='hasPriorIllness' onChange={handleCheckbox}
                        ></Checkbox>
                    </Grid>

                    <Grid item xs={6} >
                        <TextField label="Year" color='secondary' type='number' fullWidth
                            value={insuranceData.diagnosisYear} name='itemsValue'
                            onChange={handleChange} disabled={insuranceData.hasPriorIllness}
                            variant='outlined' placeholder='Year of Diagnosis' required />
                    </Grid>
                    <Grid item xs={12}>
                        <TextField label="Names" color='secondary' type='text' fullWidth
                            value={insuranceData.priorIllnessName} name='priorIllnessName'
                            onChange={handleChange} disabled={insuranceData.hasPriorIllness}
                            variant='outlined' 
                            placeholder='Enter Illness Name for example - diabetes, Hypertension, Any earlier surguries' 
                            required />
                    </Grid>
                    <Grid item xs={12} sm={6}>
                        <Button variant='contained' color='secondary' fullWidth onClick={handleBack}>Back</Button>
                    </Grid>
                    <Grid item xs={12} sm={6}>
                        <Button variant='contained' type='submit' color='secondary' fullWidth onClick={handleNext} >Next</Button>
                    </Grid>
                </Grid>
            </form>
        </div>
    )
}
