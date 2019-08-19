#!/bin/bash
#./gradlew acceptanceTest -Dcalculator.url=http://localhost:8081
./gradlew acceptanceTest -Dcalculator.url=http://host.docker.internal:8765
