import requests
from PIL import Image

key = 'AIzaSyC6qIqWHriLbbRqtUCWSznc0q5phTV3rWs'
base_url = 'https://maps.googleapis.com/maps/api/streetview?location={}&size={}' + f'&key={key}'

def request_image(lat, lng, size='400x400'):
    r = requests.get(base_url.format(str(lat)+','+str(lng), size, key))
    return r

if __name__ == "__main__":
    r = request_image(46.414382, 10.013988)
    with open('tmp.jpg', 'wb') as f:
        f.write(r.content)