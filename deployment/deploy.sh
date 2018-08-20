#! /bin/bash

ssh-keyscan  $DEPLOYMENT_SERVER >> ~/.ssh/known_hosts
scp -i ~/.ssh/id_rsa_ab7c42aebeba55bc1d50f35b575e2325 \
    agility-attendee-sessions/target/agility-attendee-session.jar \
    $DEPLOYMENT_USER@$DEPLOYMENT_SERVER:/home/$DEPLOYMENT_USER
scp -i ~/.ssh/id_rsa_ab7c42aebeba55bc1d50f35b575e2325 \
    agility-combined/target/agility-combined.jar \
    $DEPLOYMENT_USER@$DEPLOYMENT_SERVER:/home/$DEPLOYMENT_USER
scp -i ~/.ssh/id_rsa_ab7c42aebeba55bc1d50f35b575e2325 \
    agility-registration/target/agility-registration.jar \
    $DEPLOYMENT_USER@$DEPLOYMENT_SERVER:/home/$DEPLOYMENT_USER

ssh -i ~/.ssh/id_rsa_ab7c42aebeba55bc1d50f35b575e2325 'java -jar agility-attendee-sessions/target/agility-attendee-session.jar >> agility-attendee.log & java -jar agility-combined/target/agility-combined.jar >> agility-combined.log & java -jar agility-registration/target/agility-registration.jar >> agility-registration.log'
