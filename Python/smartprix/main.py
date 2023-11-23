import time
import requests
import pandas as pd
from selenium.common.exceptions import StaleElementReferenceException
from selenium import webdriver
from selenium.webdriver.common.by import By


class Smartprix:
    def __init__(self, url):
        self.url = url
        self.initializeDriver()
        self.dataFrame = pd.DataFrame()

    def initializeDriver(self):
        self.driver = webdriver.Chrome()
        self.driver.maximize_window()
        self.driver.implicitly_wait(10)
        self.driver.get(self.url)

    def getProducts(self):
        try:
            loadmore = self.driver.find_element(By.CLASS_NAME, "sm-load-more")
        except Exception as e:
            pass

        try:
            while loadmore.is_displayed():
                loadmore.click()
                time.sleep(2)

                loadmore = self.driver.find_element(
                    By.CLASS_NAME, "sm-load-more")
        except Exception as e:
            pass

        products = self.driver.find_elements(By.CLASS_NAME, "sm-product")
        print("Number of products: ", len(products))

        for product in products:
            try:
                name = product.find_element(By.TAG_NAME, "h2").text
                link = product.find_element(
                    By.TAG_NAME, "a").get_attribute("href")

                self.dataFrame = self.dataFrame._append(
                    {"Name": name, "Link": link}, ignore_index=True
                )
                print("Product added:")
                print("Name: ", name)
                print("Link: ", link)
                print("---------------------------------------------------------------")

            except Exception as e:
                pass

        self.driver.quit()

    def writeData(self):
        writer = pd.ExcelWriter(
            "C:/Users/aksha/development/DSA/Python/smartprix/rawData.xlsx", engine="xlsxwriter")
        self.dataFrame.to_excel(writer, sheet_name="Sheet1")
        writer._save()


if __name__ == "__main__":
    # URL = "https://www.smartprix.com/laptops/14_inch_15_inch-display/16_gb_above-ram/512_gb_ssd_above-ssd/exclude_out_of_stock-exclude_upcoming-stock"
    URL = "https://www.smartprix.com/laptops/price-above_50000/14_inch_15_inch-display/16_gb_above-ram/512_gb_ssd_above-ssd/exclude_out_of_stock-exclude_upcoming-stock"

    smartprix = Smartprix(URL)
    smartprix.getProducts()
    smartprix.writeData()
