#!/bin/bash -ex
rsync -avz -e ./ssh-vagrant ./target/*-all/ vagrant:.
./ssh-vagrant vagrant java -jar junit-*.jar -report reports lib/ || true
rsync -avz -e ./ssh-vagrant vagrant:reports/ ./reports/
