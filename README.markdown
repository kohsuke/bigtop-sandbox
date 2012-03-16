# What is this?

This is a prototype that combines [Apache BigTop](http://incubator.apache.org/bigtop/), [JUnit stand-alone runner](http://cloudbees.github.com/junit-standalone-runner/), and [Vagrant](http://vagrantup.com/) so that we can do blackbox testing of [Jenkins](http://jenkins-ci.org/) packages on native platforms without requiring any complex environment setup by developers.

# Pre-requisites

- Maven
- Vagrant

# How to run

First provision vagrant VM:

    vagrant up

Then, build the test with Maven.

    mvn install

Run the test in the virtual machine:

    ./run.sh

Reports will be available in the `./reports` directory of the host system in the Ant JUnit XML. When done, destroy VM with `vagrant destroy`
