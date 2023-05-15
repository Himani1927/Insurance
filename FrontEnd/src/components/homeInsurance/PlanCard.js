import { CurrencyRupee } from '@mui/icons-material'
import { Button, Card, CardContent, Typography } from '@mui/material'
import React from 'react'

export default function PlanCard({plan}) {


  return (
    <Card style={{backgroundColor:'lightblue' , height:'100%'}}>
      <CardContent>
        <Typography variant="h6">{plan.planName}</Typography>
        <Typography variant="subtitle1">{plan.planType}</Typography>
        <Typography variant="subtitle2">{plan.planFeatures.join(', ')}</Typography>
        <Typography variant="h5"><CurrencyRupee/> {plan.basePrice}/month</Typography>
        <Typography variant="h5"><CurrencyRupee/>Total Premium {plan.totalPrice}</Typography>
        <Button  variant="contained" style={{marginTop:'30px'}}  color="primary">Select</Button>
      </CardContent>
    </Card>
  )
}
