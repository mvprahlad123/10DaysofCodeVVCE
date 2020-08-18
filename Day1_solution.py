#!/bin/python3

import os
import subprocess
import math
import random
import sys
import re


if __name__ == "__main__":    
  nd = input().split()

  size = int(nd[0])

  rot = int(nd[1])
  a = list(map(int, input().rstrip().split()))
  rot_arr = [int(0) for i in range(size)]

  for i in range(0,size):
    rot_index = int((i+size-rot)%size)
    rot_arr[rot_index] = a[i] 

  print(*rot_arr)
