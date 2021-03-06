/* Copyright (C) Intel 2015
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

#ifndef PARSER_H
#define PARSER_H
#include "dvcdesc_internal.h"

struct num_array {
	unsigned int len;
	unsigned long long *elems;
};

enum pair_type {
	P_NUM,
	P_STRING,
	P_NUM_ARRAY,
};

struct pair {
	enum pair_type type;
	union {
		unsigned long long num;
		char *str;
		struct num_array *num_array;
	} v;
	char *name;
	struct pair *next;
};

struct pair_list {
	struct pair *first, *last;
};

struct pair *new_num_pair(char *name, unsigned long long number);
struct pair *new_str_pair(char *name, char *str);
struct pair *new_arr_pair(char *name, struct num_array *arr);

struct pair_list *new_pair_list(struct pair *pair);
struct pair_list *pair_list_add(struct pair_list *pl, struct pair *pair);

struct num_array *new_arr();
struct num_array *arr_add(struct num_array *arr, unsigned long long number);

void flush_obj(struct dvc_descriptors *descs, int type, struct pair_list *pl);

#endif /*PARSER_H*/
