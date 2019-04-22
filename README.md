easy-loader
=================================
This is an android library that helps to load resources (Image, JSON) from server and show in android application.
## Feature
It provides the following features :

- Very easy to use for loading image and josn as well
- The library can show image or load bitmap
- Support default image list
- Provides simple object mapper for json response 

## Dependency
Step 1. Add the Library module in your project

Step 2. Add the dependency

	dependencies {
	        implementation project(path: ':easyloader')
	}
  
## Usage
Single Image loading :

       EasyLoader
            .imageBuilder()
            .src(url)
            .container(imageView)
            .cacheLimit(100)
            .build()
            .show()
            
            
Single Image load as Bitmap

       EasyLoader
            .imageBuilder()
            .src(url)
            .container(imageView)
            .cacheLimit(100)
            .build()
            .loadBitmap(object : DefaultDataHandler(){
                override fun onSuccess(data: Any) {
                    super.onSuccess(data)
                    var image : Bitmap = data as Bitmap
                }

                override fun onFailure(error: Any) {
                    super.onFailure(error)
                }
            })
            
            
 Show image list using library:
 
        EasyLoader
            .imageBuilder()
            .cacheLimit(100)
            .asList()
            .src(urls)
            .container(recyclerView)
            .build()
            .show()
            
 Simple Json loader :
 
        EasyLoader
            .jsonBuilder()
            .src(url)
            .build()
            .loadJSON(object : DefaultDataHandler() {
                override fun onSuccess(data: Any) {
                    super.onSuccess(data)
                    
                   val jsonObject: JSONObject = data as JSONObject
                    //or 
                    val jsonArray : JSONArray = data as JSONArray
                }

                override fun onFailure(error: Any) {
                    super.onFailure(error)
                }
            })

        

### Licence         
Apache License, Version 2.0

    Copyright (C) 2019, Julkar Nain

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at
   
        http://www.apache.org/licenses/LICENSE-2.0
     
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
        
        
