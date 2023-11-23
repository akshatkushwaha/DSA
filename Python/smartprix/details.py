import requests
import json
from bs4 import BeautifulSoup
import pandas as pd
import logging
import time


def getHeaders(URL):
    page = requests.get(URL)
    soup = BeautifulSoup(page.content, "html.parser")

    specsTable = soup.find_all("div", class_="sm-fullspecs-grp")

    specs = []
    for table in specsTable:
        tableSections = table.find_all("td", class_="title")
        for section in tableSections:
            specs.append(section.text)

    return specs


def getSpecs(URL):
    page = requests.get(URL)
    soup = BeautifulSoup(page.content, "html.parser")

    specsTable = soup.find_all("div", class_="sm-fullspecs-grp")

    specs = []
    for table in specsTable:
        data = table.find_all("span")
        for d in data:
            logging.info(d.text)
            specs.append(d.text)

    return specs


def createSpecsDict(name, headers, specs):
    specsDict = {}
    specsDict["Name"] = name

    if len(headers) != len(specs):
        logging.error("Headers and Specs don't match")
        return specsDict

    for i in range(len(headers)):
        specsDict[headers[i]] = specs[i]

    return specsDict


if __name__ == "__main__":
    data = pd.read_excel(
        "C:/Users/aksha/development/DSA/Python/smartprix/rawData.xlsx", sheet_name="Sheet1")

    names = data["Name"]
    URL = data["Link"]

    dataFrame = pd.DataFrame()

    for i in range(len(URL)):
        time.sleep(2)
        specs = getSpecs(URL[i])
        headers = getHeaders(URL[i])
        specsDict = createSpecsDict(names[i], headers, specs)

        dataFrame = dataFrame._append(specsDict, ignore_index=True)

        logging.info(str(i) + " Collecting data for: ", names[i])
        logging.info(URL[i])
        logging.info("-------------------------------------------")

    # write to excel
    writer = pd.ExcelWriter(
        "C:/Users/aksha/development/DSA/Python/smartprix/laptops.xlsx", engine="xlsxwriter")

    dataFrame.to_excel(writer, sheet_name="Sheet1")

    writer._save()

    print(dataFrame)
