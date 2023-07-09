import serial
from telegram import Bot

# Telegram bot token
BOT_TOKEN = '5848275429:AAE3C3PzxyLmZKUtxoXjHhLS_Lhc5H7TOnk'
# Telegram chat ID
CHAT_ID = 'rfid_serial_comm_bot'

# Establish serial communication with Arduino Nano
ser = serial.Serial('/dev/ttyUSB0', 9600)  # Replace with the correct port and baud rate

# Initialize the Telegram bot
bot = Bot(token=BOT_TOKEN)

while True:
    # Read data from Arduino
    data = ser.readline().decode().strip()

    # Send Telegram message
    bot.send_message(chat_id=CHAT_ID, text=data)
