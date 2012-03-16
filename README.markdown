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
