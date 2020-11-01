# Circle-Board
It is a Custom View for display your sensor readings, values and other. It has many attributes for fully customize.
By default it looks like this

![1](https://user-images.githubusercontent.com/73692864/97799999-13c09080-1c3a-11eb-8aae-2f749922b510.png)

1. Angels of scale of divisions (sets angle from vertical):

app:grid_angel_start="-135"

app:grid_angel_end="135"

For example, next screnshots show next value (-135; 135), (-90;90); (0;90):

![1](https://user-images.githubusercontent.com/73692864/97804315-9dcb2200-1c57-11eb-8583-9568e8ef8a66.png)
![2](https://user-images.githubusercontent.com/73692864/97804312-9d328b80-1c57-11eb-96d5-2969f960409d.png)
![3](https://user-images.githubusercontent.com/73692864/97804314-9dcb2200-1c57-11eb-997d-61fc35eecebb.png)


2. Min and max numbers of scale

app:number_min="-40"

app:number_max="50"

For example, board for car speed (0;220), barometer (720;780), in-temperature (10;40), out-temperature (-40;50)

![4 speed](https://user-images.githubusercontent.com/73692864/97800610-4b7e0700-1c3f-11eb-9410-d4e6a19b72d3.png)
![4 baro](https://user-images.githubusercontent.com/73692864/97800614-520c7e80-1c3f-11eb-8c6f-e99213ebfe11.png)
![4 flat](https://user-images.githubusercontent.com/73692864/97800619-5769c900-1c3f-11eb-879e-e93b8c6cab81.png)
![4 out](https://user-images.githubusercontent.com/73692864/97800623-5afd5000-1c3f-11eb-9599-cf9bab2e9ad5.png)

3. Number of large tick marks (which have digital signatures)

 app:grid_large_number="10"
 
 For example, next values (3,6,15,30) look like:
 
![5-3](https://user-images.githubusercontent.com/73692864/97802643-796a4800-1c4d-11eb-9299-4677408f53b7.png)
![5-6](https://user-images.githubusercontent.com/73692864/97802639-78391b00-1c4d-11eb-90ad-3ae623e23937.png)
![5-15](https://user-images.githubusercontent.com/73692864/97802641-78d1b180-1c4d-11eb-961e-e392f8c6c13f.png)
![5-30](https://user-images.githubusercontent.com/73692864/97802642-796a4800-1c4d-11eb-9687-cccecf30587e.png)
 
 Attention! The range of values (number_max - number_min) must be divided without a remainder. For example, for values 10-40, the range is 40-10=30, therefore grid_large_number can take values 2, 3, 5, 6, 10, 15, 30

4.Number of small tick marks (between large tick marks)
 For example, next values (2,5,10) look like:
 
 ![6-2](https://user-images.githubusercontent.com/73692864/97802910-58a2f200-1c4f-11eb-8256-a19957621412.png)
![6-5](https://user-images.githubusercontent.com/73692864/97802972-af103080-1c4f-11eb-92dc-b888b3eaaded.png)
![6-10](https://user-images.githubusercontent.com/73692864/97802909-580a5b80-1c4f-11eb-8101-d259e2f41de8.png)

5.Size of ticks:

app:grid_large_width="2dp"

app:grid_large_height="6dp"

app:grid_small_width="1dp"

app:grid_small_height="3dp"

For example different values:

![7-1](https://user-images.githubusercontent.com/73692864/97803177-06fb6700-1c51-11eb-8691-589654e78d01.png)
![7-2](https://user-images.githubusercontent.com/73692864/97803178-0793fd80-1c51-11eb-96bd-c562d65baef0.png)



6.Appearance of clock arrow

app:clock_hand_center_ring_radius="5dp"

app:clock_hand_tail_height="30dp"

app:clock_hand_width="4dp"

app:clock_hand_height="140dp"

app:clock_hand_volume="true"

app:clock_hand_color="@color/purple_200"

app:clock_hand_round_radius="5dp"


For example different values:

![8-1](https://user-images.githubusercontent.com/73692864/97803451-6b6af600-1c52-11eb-823d-e4a95e3248e3.png)
![8-2](https://user-images.githubusercontent.com/73692864/97803454-6c038c80-1c52-11eb-8bc9-ed0d3ef9eddb.png)


7. Appearance of clock face

app:board_color_in="#FFEA9C"

app:board_color_out="#754700"

app:rim_width="30dp"

app:rim_color="#783400"

app:rim_volume="true"

app:grid_text_color="#FFFFFF"

app:grid_small_color="#DDDDDD"

app:grid_large_color="#E3E3E3"


For example different variants:

![9-3](https://user-images.githubusercontent.com/73692864/97804134-8b041d80-1c56-11eb-8a66-ee1624d8c60e.png)
![9-4](https://user-images.githubusercontent.com/73692864/97804135-8b9cb400-1c56-11eb-88b1-c5c415d68d1d.png)
![9-5](https://user-images.githubusercontent.com/73692864/97804136-8c354a80-1c56-11eb-8065-d6ca4044874d.png)
![9-6](https://user-images.githubusercontent.com/73692864/97804137-8c354a80-1c56-11eb-89ad-f27e187d0d67.png)
![9-7](https://user-images.githubusercontent.com/73692864/97804138-8ccde100-1c56-11eb-8f6e-be16f0059179.png)
![9-1](https://user-images.githubusercontent.com/73692864/97804139-8ccde100-1c56-11eb-8b95-971cb90a9834.png)
![9-2](https://user-images.githubusercontent.com/73692864/97804140-8ccde100-1c56-11eb-9b00-b4dd42fb0bb7.png)

You can set transparent board color and customize your board stronger!



