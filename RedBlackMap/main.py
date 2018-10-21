from scipy import *
import numpy as np
import matplotlib.pyplot as plt

data = np.loadtxt('data.txt')

plt.plot(data[:,0], data[:,1], 'ro')
plt.show()