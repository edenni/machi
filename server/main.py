from typing import Optional
import random

from fastapi import FastAPI

app = FastAPI()
from street import base_url, key


@app.get("/")
def read_root():
    return {"Hello": "World"}


@app.get("/streetimage/")
async def get_images(lon: float, lat: float):
    lat = 35.6690667
    lng = 139.5633213
    K = 20
    image_list = []

    for i in range(K):
        lat += random.uniform(-0.001, 0.001)
        lng += random.uniform(-0.001, 0.001)
        img_src = base_url.format(str(lat)+','+str(lng), '400x400', key)
        image_list.append({'id': i, 'lat': lat, 'lon': lng, 'img_src':img_src, 'filter': 'None'})
    return image_list
