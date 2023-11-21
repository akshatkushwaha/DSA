import requests
import json
from bs4 import BeautifulSoup
import xlsxwriter

API_URLS = [
    "https://www.smartprix.com/ui/api/page-info?k=1SYMJDYwYlD2HLGHKl2KMKjD6FGNGj3J2F5lHJA46j36DGO0nmmmmml2E50JQR6F0rj2E50JQR6F0tjAFL6D04GJ60ArjAFL6D04GJ60Atj4HMlnq0AF490nr0AF49j5AKHD2Qlns083023GN6jJ2Elrno0830KK5023GN6jKK5l6P4DM560GML0G70KLG4Cj6P4DM560MH4GEAF8jKLG4Cln0r0C8036DGOjO6A89L_KGJLzKH640K4GJ6c2K4zmYiY52L2YwSY27L6JYwomUiYJ676JJ6JYwYYiYLYwntmmrtvomtqnpiYKLYwntmmrturqqusmU",
    "https://www.smartprix.com/ui/api/page-info?k=1SYMJDYwYlD2HLGHKl2KMKjD6FGNGj3J2F5lHJA46j36DGO0nmmmmml2E50JQR6F0rj2E50JQR6F0tjAFL6D04GJ60ArjAFL6D04GJ60Atj4HMlnq0AF490nr0AF49j5AKHD2Qlns083023GN6jJ2Elrno0830KK5023GN6jKK5l6P4DM560GML0G70KLG4Cj6P4DM560MH4GEAF8jKLG4Cln0r0C8036DGOjO6A89L_KGJLzKH640K4GJ6c2K4zmYiY52L2YwSY27L6JYwqmUiYJ676JJ6JYwYYiYLYwntmmrtvoqqpquiYKLYwntmmrtvomtovtU",
    "https://www.smartprix.com/ui/api/page-info?k=1SYMJDYwYlD2HLGHKl2KMKjD6FGNGj3J2F5lHJA46j36DGO0nmmmmml2E50JQR6F0rj2E50JQR6F0tjAFL6D04GJ60ArjAFL6D04GJ60Atj4HMlnq0AF490nr0AF49j5AKHD2Qlns083023GN6jJ2Elrno0830KK5023GN6jKK5l6P4DM560GML0G70KLG4Cj6P4DM560MH4GEAF8jKLG4Cln0r0C8036DGOjO6A89L_KGJLzKH640K4GJ6c2K4zmYiY52L2YwSY27L6JYwsmUiYJ676JJ6JYwYYiYLYwntmmrtvouqpsmiYKLYwntmmrtvoqqnruU"
]

productList = []


def processeFristTwentyLaptops():
    URL = "https://www.smartprix.com/laptops/asus-lenovo-brand/price-below_100000/amd_ryzen_5-amd_ryzen_7-intel_core_i5-intel_core_i7-cpu/14_inch_15_inch-display/16_gb_above-ram/512_gb_ssd_above-ssd/exclude_out_of_stock-exclude_upcoming-stock/1_5_kg_below-weight?sort=spec_score&asc=0"
    page = requests.get(URL)

    soup = BeautifulSoup(page.content, "html.parser")
    script = soup.find_all("script")[3]

    data = json.loads(script.string)

    itemList = data["itemListElement"]

    for item in itemList:
        product = {
            "name": item["name"],
            "url": item["url"]
        }
        productList.append(product)


def processRestUsingAPI(API_URLS):
    for url in API_URLS:
        data = requests.get(url).json()
        itemList = data["item"]["searchResults"]["nodes"]

        for item in itemList:
            product = {
                "name": item["name"],
                "url": "https://www.smartprix.com" + item["url"]
            }
            productList.append(product)


def getLaptopDetails(URL):
    page = requests.get(URL)
    soup = BeautifulSoup(page.content, "html.parser")


if __name__ == "__main__":
    processeFristTwentyLaptops()
    processRestUsingAPI(API_URLS)

    workbook = xlsxwriter.Workbook(
        "C:/Users/aksha/development/DSA/Python/smartprix/raw.xlsx")
    worksheet = workbook.add_worksheet()

    row = 0
    col = 0

    for product in productList:
        worksheet.write(row, col, product["name"])
        worksheet.write(row, col+1, product["url"])
        row += 1

    workbook.close()

    print("Done")
