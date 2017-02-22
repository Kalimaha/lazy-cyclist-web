#!/bin/bash

echo "Initial clean up: START"
rm -rf dist/universal
rm -rf target
echo "Initial clean up: DONE"

echo "Build project: START"
sbt compile stage
echo "Build project: DONE"

echo "Move deliverable: START"
cp target/universal dist/
echo "Move deliverable: DONE"

echo "Push to master: START"
git add . && git commit -m 'Deploy to Heroku.' && git push origin master
echo "Push to master: DONE"