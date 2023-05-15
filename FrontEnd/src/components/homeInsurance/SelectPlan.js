import React, { useEffect, useState } from 'react'
import { getHomeInsurancePlans } from '../../services/PolicyService'
import { Button, Card, CardContent, Grid, MenuItem, Select, TextField, Typography } from '@mui/material';
import { CurrencyRupee } from '@mui/icons-material';


export default function SelectPlan({
    insuranceData, setInsuranceData, plans, setPlans, handleNext, handleBack
}) {

    const [duration, setDuration] = useState(insuranceData.policyDetails.durationInYears)

    const handleChange = (e) => {
        setInsuranceData((prevState) => ({
            ...prevState, policyDetails: {
                ...prevState.policyDetails,
                [e.target.name]: e.target.value
            }
        }));
        setDuration(e.target.value)
    }

    let type, planCover
    if (insuranceData.insureBuilding && insuranceData.insureHouseholdItems) {
        type = "BOTH";
        planCover = Math.max(insuranceData.buildingValue, insuranceData.itemsValue)
    } else if (insuranceData.insureBuilding) {
        type = "BUILDING";
        planCover = insuranceData.buildingValue
    } else {
        type = "Household-Items";
        planCover = insuranceData.itemsValue
    }


    useEffect(() => {
        loadPlans();
    }, [])

    const loadPlans = async () => {
        const data = await getHomeInsurancePlans(type, duration, planCover)
        setPlans(data);
        console.log(insuranceData)
    }

    const handleSelect = (plan) => {
        setInsuranceData({
            ...insuranceData,
            policyDetails: {
                ...insuranceData.policyDetails,
                planCode: plan.planCode,
                totalPremium: plan.totalPrice
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
                        <MenuItem value={4} >4</MenuItem>
                        <MenuItem value={5} >5</MenuItem>
                        <MenuItem value={6} >6</MenuItem>
                        <MenuItem value={7} >7</MenuItem>
                        <MenuItem value={8} >8</MenuItem>
                        <MenuItem value={9} >9</MenuItem>
                        <MenuItem value={10} >10</MenuItem>
                    </Select> in years
                    <Button variant="contained" onClick={loadPlans}>Filter</Button>
                </Grid>
                {plans.map((plan) => (
                    <Grid key={plan.planCode} item xs={12} sm={6} md={4} spacing={1}>
                        {/* <PlanCard plan={plan} /> */}
                        <Card style={{ backgroundColor: 'lightblue', height: '100%' }}>
                            <CardContent>
                                <Typography variant="h6">{plan.planName}</Typography>
                                <Typography variant="subtitle1">{plan.planType}</Typography>
                                <Typography variant="subtitle2">{plan.planFeatures.join(', ')}</Typography>
                                <Typography variant="h5"><CurrencyRupee /> {plan.basePrice}/month</Typography>
                                <Typography variant="h5"><CurrencyRupee />Total Premium {plan.totalPrice}</Typography>
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
            </Grid>
        </div>
    )
}
