import pytest
import math

def test_sqrroot():
    num=25
    assert math.sqrt(num)==5

def test_square():
    num=7
    assert num*num==49    

def test_failedd():
    assert 10==12