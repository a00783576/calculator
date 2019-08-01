#!/bin/bash
test $(curl docker.for.win.localhost:8765/sum?a=1"&"b=2) -eq 3
./gradlew acceptanceTest -Dcalculator.url=docker.for.win.localhost:8765
