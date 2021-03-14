from PIL import Image
from io import BytesIO
import cv2
import sys
import numpy as np
import base64
np.set_printoptions(threshold=sys.maxsize)

cap = cv2.VideoCapture("test.mp4")

while(True):

    retval, image = cap.read()
    retval, buffer = cv2.imencode('.jpg', image)
    jpg_as_text = base64.b64encode(buffer)
    print((jpg_as_text.decode('utf-8')))

sys.exit()
