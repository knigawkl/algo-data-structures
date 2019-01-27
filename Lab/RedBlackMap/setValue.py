from scipy import *
import numpy as np
import matplotlib.pyplot as plt

data = np.loadtxt('set_value_data.txt')

plt.plot(data[:,0], data[:,1], 'ro')
plt.xlabel('N')
plt.ylabel('t[ns]')
plt.title('Setting value')
plt.show()