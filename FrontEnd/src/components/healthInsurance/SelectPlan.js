import { CurrencyRupee } from '@mui/icons-material';
import { Button, Card, CardContent, Grid, MenuItem, Select, Typography } from '@mui/material'
import React, { useEffect, useState } from 'react'
import { getHealthInsurancePlans } from '../../services/PolicyService';

export default function SelectPlan({
    insuranceData, setInsuranceData, plans, setPlans, handleNext, handleBack
}) {

    const [duration, setDuration] = useState(insuranceData.policyDetails.durationInYears)
    const [cover, setCover] = useState(insuranceData.policyDetails.policyCover)
    let age = insuranceData.age


    const handleChange = (e) => {
        setInsuranceData((prevState) => ({
            ...prevState, policyDetails: {
                ...prevState.policyDetails,
                [e.target.name]: e.target.value
            }
        }));
        if (e.target.name === 'durationInYears') {
            setDuration(e.target.value)
        }else if(e.target.name === 'policyCover'){
            setCover(e.target.value)
        }
        console.log(insuranceData)
    }

    useEffect(() => {
        loadPlans();
    }, [])

    const loadPlans = async () => {
        console.log(insuranceData)
        const data = await getHealthInsurancePlans(age, duration, cover, insuranceData.hasPriorIllness)
        setPlans(data);

    }

    const handleSelect = (plan) => {
        setInsuranceData({
            ...insuranceData,
            policyDetails: {
                ...insuranceData.policyDetails,
                planCode: plan.planCode,
                totalPremium: plan.costWithGst,
            }
        });
        console.log(insuranceData)
        handleNext()
    };

    return (
        <div>
            <Grid container spacing={2}>
                <Grid item xs={12}>
                    <Typography variant="h5">Select a plan</Typography>
                </Grid>
                <Grid item xs={12}>
                    <Typography sx={{ display: 'inline' }}>Duration  </Typography>
                    <Select value={insuranceData.policyDetails.durationInYears}
                        name='durationInYears' onChange={handleChange} size='small'
                        displayEmpty>
                        <MenuItem value="" disabled>Select Duration</MenuItem>
                        <MenuItem value={1} >1</MenuItem>
                        <MenuItem value={2} >2</MenuItem>
                        <MenuItem value={3} >3</MenuItem>
                        <MenuItem value={5} >5</MenuItem>
                    </Select> in years
                    <Typography marginLeft={'10px'} sx={{ display: 'inline' }}> Cover </Typography>
                    <Select value={insuranceData.policyDetails.policyCover}
                        name='policyCover' onChange={handleChange} size='small'
                        displayEmpty>
                        <MenuItem value="" disabled>Select Amount</MenuItem>
                        <MenuItem value={100000} >1 lakh</MenuItem>
                        <MenuItem value={200000} >2 Lakh</MenuItem>
                        <MenuItem value={400000} >4 Lakh</MenuItem>
                    </Select>
                    <Button variant="contained" style={{ marginLeft: '12px' }} onClick={loadPlans}>Filter</Button>
                </Grid>
                {plans.map((plan) => (
                    <Grid key={plan.planCode} item xs={12} sm={6} md={4} spacing={1}>
                        {/* <PlanCard plan={plan} /> */}
                        <Card style={{ backgroundColor: 'lightblue', height: '100%' }}>
                            <CardContent>
                                <Typography variant="h6">{plan.planName}</Typography>
                                <Typography variant="subtitle2">{plan.planFeatures.join(', ')}</Typography>
                                <Typography variant="h5"><CurrencyRupee /> {plan.basePrice}/month</Typography>
                                <Typography variant="h5"><CurrencyRupee />Total Premium {plan.totalCost}</Typography>
                                <Typography variant="h5"><CurrencyRupee />with GST {plan.costWithGst}</Typography>
                                <Button variant="contained" style={{ marginTop: '30px' }}
                                    color="primary" onClick={() => handleSelect(plan)}>Select
                                </Button>
                            </CardContent>
                        </Card>
                    </Grid>
                ))}
                <Grid item xs={12}>
                    <Button variant='contained' color='secondary' fullWidth onClick={handleBack}>Back</Button>
                </Grid>
                <Grid item xs={12} >
                    <Button variant='contained' type='submit' color='secondary' fullWidth onClick={handleNext} >Next</Button>
                </Grid>
            </Grid>
        </div>
    )
}
