# -*- coding: utf-8 -*-
"""
Created on Sun Aug 27 11:20:13 2023

@author: Marc
"""

import speech_recognition as sr
AUDIO_FILE=("ZL_Project.wav")
r=sr.Recognizer()
with sr.AudioFile(AUDIO_FILE) as source:
    audio = r.record(source)
    
try :
    print("audio file contains: "+ r.recognize_google(audio))
except sr.UnknownValueError :
    print("Google can't understand file")
except sr.RequestError :
    print("Can't get results from google")
    