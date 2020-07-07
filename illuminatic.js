import React, { Component } from 'react';

import { withStyles } from '@material-ui/core/styles';
import Grid from '@material-ui/core/Grid';
import { Typography, Button } from '@material-ui/core';

const styles = (theme) => ({
  root: {
    flexGrow: 1,
    paddingLeft: '1vw',
    paddingRight: '1vw',
  },
  hellotext: {
    fontSize: '4vw',
    color: '#FFFFFFA6',
    height: '10vh',
  },
  hellotext1: {
    fontSize: '2.5vw',
    marginTop: '5vh',
    padding: '1vh',
    color: '#FFFFFF',
    backgroundColor: '#5DAAE0',
  },
  hellotext3: {
    fontSize: '1vw',
    marginTop: '5vh',
    padding: '0.5vh',
    color: '#FFFFFF',
    backgroundColor: '#5DAAE0',
  },
  hellotext2: {
    fontSize: '1.2vw',
    marginTop: '5vh',
    padding: '1vh',
    color: '#FFFFFF',
    backgroundColor: '#5DAAE0',
  },
  hellotext4: {
    fontSize: '1.5vw',
    marginTop: '2vh',
    padding: '1vh',
    color: '#FFFFFF',
  },
  searchBtn: {
    marginTop: '2vh',
    minWidth: '5vw',
    minHeight: '2.188vw',
    fontSize: '0.95vw',
    border: 'solid 0.75px #3B617C',
    // marginRight: '0.5rem',
    alignSelf: 'center',
    color: '#5DAAE0',
    '&:hover': {
      backgroundColor: '#5daae0',
      color: 'white',
    },
  },
});

class CustomerDetails extends Component {
  constructor(props) {
    super(props);
    this.state = {};
  }

  componentDidMount() {}

  render() {
    console.log('Data', this.props);
    const { classes } = this.props;
    return (
      <Grid container className={classes.root} spacing={2} xs={12}>
        <Grid container style={{ height: '95vh' }} justify="center">
          <Grid
            item
            //style={{height:'40vh',width:'60vh',backgroundColor:'#252C48'}}
            alignItems="center"
            direction="column"
            container
          >
            <Typography className={classes.hellotext}>
              Hello {this.props.location.state.name}
            </Typography>
            <Typography className={classes.hellotext1}>
              WELCOME TO SUMMER INTERNSHIP 2020
            </Typography>
            <div
              style={{
                display: 'flex',
                flexDirection: 'column',
                alignItems: 'center',
                justifyContent: 'center',
                height: '30vh',
                width: '51vw',
                marginTop: '5vh',
                border: 'solid 1px #5daae0',
              }}
            >
              <Button
                size="medium"
                className={classes.searchBtn}
                onClick={this.handleGetStarted}
              >
                CLICK HERE TO GET THE COMPLETE SOURCE CODE OF THE PROJECT
              </Button>
              <Button
                size="medium"
                className={classes.searchBtn}
                onClick={this.handleGetStarted}
              >
                CLICK HERE TO BRIBE YOUR MODERATOR DURING EVALUATION
              </Button>

              <Button
                size="medium"
                className={classes.searchBtn}
                onClick={this.handleGetStarted}
              >
                CLICK HERE TO GET ALL UPCOMING QUIZ ANSWERS BEFOREHAND
              </Button>
            </div>
            <Typography className={classes.hellotext3}>
              WITH LOTS OF LOVE,
            </Typography>
            <Typography className={classes.hellotext4}>
              Highradius Illuminati
            </Typography>
            <Typography className={classes.hellotext2}>
              THE ILLUMINATI WILL BE THERE WITH YOU ALWAYS...AND WILL HELP YOU
              WHENEVER YOU ARE STUCK. MAY THE FORCE BE WITH YOU
            </Typography>
          </Grid>
        </Grid>
      </Grid>
    );
  }
}

export default withStyles(styles, { withTheme: true })(CustomerDetails);
