#!/bin/bash
result=$(docker ps | grep "139.198.18.79:5000/xc-govern-center")
if [[ "$result" != "" ]]
then
echo "stop xc-govern-center"
docker stop xc-govern-center
fi
result1=$(docker ps -a | grep "139.198.18.79:5000/xc-govern-center")
if [[ "$result1" != "" ]]
then
echo "rm xc-govern-center"
docker rm xc-govern-center
fi
result2=$(docker images | grep "139.198.18.79:5000/xc-govern-center")
if [[ "$result2" != "" ]]
then
echo "139.198.18.79:5000/xc-govern-center:1.0-SNAPSHOT"
docker rmi 139.198.18.79:5000/xc-govern-center:1.0-SNAPSHOT
fi