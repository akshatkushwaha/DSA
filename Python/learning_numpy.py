import numpy as np

arr = np.array([1, 2, 3, 4, 5])  # create a numpy 1-D array

# arr = np.array([[1, 2, 3, 4, 5], [1, 2, 3, 4, 5], [1, 2, 3, 4, 5]]) # create a numpy 2-D array

arr = np.array([1, 2, 3, 4], ndmin=5)  # create a numpy 5-D array
# [[[[[1 2 3 4]]]]] # ndmin=5

print(arr)
print(arr.ndim)
