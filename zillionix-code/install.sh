#!/bin/bash
set -x
#installing Python 2.7 
echo "installing Python 2.7.."
wget https://repo.continuum.io/miniconda/Miniconda-latest-Linux-x86_64.sh
sudo sh Miniconda-latest-Linux-x86_64.sh -b -p /usr/local/miniconda
echo "export PATH=/usr/local/miniconda/bin:$PATH" >> ~/.bashrc
source ~/.bashrc
sudo alias python2.7="/usr/local/miniconda/bin/python"
sudo alias python2.6="/usr/bin/python"
sudo conda install pip
which pip
echo "Install python packages"
sudo /usr/local/miniconda/bin/pip install pandas_datareader
sudo /usr/local/miniconda/bin/pip install flask_sqlalchemy
sudo /usr/local/miniconda/bin/pip install sqlalchemy
sudo yum install MySQL-python -y
sudo yum install mysql-devel -y
sudo /usr/local/miniconda/bin/pip install mysql-python
sudo /usr/local/miniconda/bin/pip install fix_yahoo_finance
sudo /usr/local/miniconda/bin/pip install pyspark
sudo cp /etc/hive/conf/hive-site.xml /etc/spark/conf/
