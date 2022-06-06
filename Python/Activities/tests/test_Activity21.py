import pytest
import math

def test_SumofNum():
    num1=40
    num2=30
    sum =num1+num2
    print(num1+num2)
    assert sum==70

def test_DiffofNum():
    num1=40
    num2=30
    print(num1-num2)  
    diff = num1-num2
    assert diff ==10
  
def test_MultiofNum():
    num1=40
    num2=30 
    multi =num1*num2
    assert multi ==1200 

def test_DivofNum():
    num1=40
    num2=30 
    quat =int(num1/num2)
    assert quat ==1    
