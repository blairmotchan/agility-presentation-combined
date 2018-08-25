#! /bin/bash

ssh-keyscan  $DEPLOYMENT_SERVER >> ~/.ssh/known_hosts

scp -i ~/.ssh/id_rsa_ab7c42aebeba55bc1d50f35b575e2325 \
    agility-combined/target/agility-combined.jar \
    $DEPLOYMENT_USER@$DEPLOYMENT_SERVER:/home/$DEPLOYMENT_USER

ssh -i ~/.ssh/id_rsa_ab7c42aebeba55bc1d50f35b575e2325 $DEPLOYMENT_USER@$DEPLOYMENT_SERVER 'kill -9 $(lsof -t -i:8081) & /usr/bin/java -jar agility-combined.jar >> agility-combined.log &'
